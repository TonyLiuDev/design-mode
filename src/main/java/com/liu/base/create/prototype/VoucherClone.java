package com.liu.base.create.prototype;

/**
 * 开收据（不同收据金额不同）
 */
public class VoucherClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        // companyA 开了张 100元的收据
        Voucher v100 = new Voucher(100L, "companyA");
        // 生成新的收据
        Voucher vNew = (Voucher)v100.clone();
        // 重写填写金额
        vNew.setAmount(200L);
    }
}

// 收据类
class Voucher implements Cloneable{
    private Long amount;
    private String companyName;
    public Voucher(Long amount, String companyName) {
        this.amount = amount;
        this.companyName = companyName;
    }
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    // 重写clone,父类是protected修饰
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

