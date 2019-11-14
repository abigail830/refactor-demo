package demo1;

/**
 *  影片出租价格计算方式：
 *
 *  REGULAR：起步价2元，租超过2天后，每天1.5元
 *  NEW_RELEASE：每天3元，不设起步价
 *  CHILDRENS：起步价1.5元，租超过3天后，每天1.5元
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
        return customer.printStatement();
    }

}
