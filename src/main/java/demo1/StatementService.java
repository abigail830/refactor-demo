package demo1;

import java.util.List;

/**
 *  影片出租价格计算方式：
 *
 *  REGULAR：每天1元，起步价2元，租超过2天后，每天加收50%（即1.5元）
 *  NEW_RELEASE：每天3元，不设起步价
 *  CHILDRENS：每天1元，起步价1.5元，租超过3天后，每天加收50%（即1.5元）
 *
 *
 *  常客积分计算方式：
 *
 *  每租1张影碟得1积分，
 *  如果是新片而且租超过1天的话，再加1积分
 *
 */
public class StatementService {

    public String printStatement(Customer customer) {

        double totalAmount = 0; // 总消费金。
        int frequentRenterPoints = 0; // 常客积点

        String result = "Rental Record for " + customer.getName() + "\n";

        for (Rental rental : customer.getRentalList()) {

            double thisAmount = 0;

            // 取得影片出租价格
            switch (rental.getMovie().getPriceCode()) {
                // 普通片
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                // 新片
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                // 儿童
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            // add frequent renter points （累计常客积点。
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental（显示此笔租借记录）
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }

        // add footer lines（结尾打印）
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";

        return result;
    }
}
