package song.basis.EnumTest.HandlerChainTest;

import song.basis.EnumTest.EnumClass;

import java.util.Iterator;

/**
 * Created by Song on 2016/10/23.
 * 采用Enum实例实现责任链模式
 * 基于不同邮件的处理情景
 */
public class PostOffice {
    enum MailHandler{
        GENERAL_DELIVERY{
            @Override
            boolean handler(Mail mail) {
                switch (mail.generalDelivery){
                    case YES:{
                        System.out.println("Use General Delivery for "+mail);
                        return true;
                    }
                    default:return false;
                }
            }
        },
        MACHINE_SCAN{
            @Override
            boolean handler(Mail mail) {
                switch (mail.scannability){
                    case UNSCANNABLE:{
                        return false;
                    }
                    default:{
                        switch (mail.address){
                            case INCORRECT:return false;
                            default:{
                                System.out.println("Delieverying "+mail+" automatically");
                                return true;
                            }
                        }
                    }
                }
            }
        };
        abstract boolean handler(Mail mail);
    }

    static void handler(Mail mail){
        for (MailHandler mh : MailHandler.values()){
            if(mh.handler(mail)) return;
        }
        System.out.println("This is a dead mail!!");
    }

    public static void main(String [] args){
        for (Mail mail:Mail.generator(10)) {
            System.out.println(mail.details());
            handler(mail);
            System.out.println("*************************************************************");
        }
    }
}

class Mail{
    enum GeneralDelivery{YES,NO1,NO2,NO3,NO4,NO5}
    enum Scannability{UNSCANNABLE,YES1,YES2,YES3,YES4}
    enum Readability{ILLEGIBLE,YES1,YES2,YES3,YES4}
    enum Address{INCORRECT,OK1,OK2,OK3,OK4,OK5}
    enum ReturnAddress{MISSING,OK1,OK2,OK3,OK4}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    long id = counter++;

    public String toString(){return "Mail "+id;}
    public String details(){
        return ". General Delivery: "+generalDelivery+
                ". Address Scannable: "+scannability+
                ". Address Readablity: "+readability+
                ". Address : "+address+
                ". Return Address: "+returnAddress;
    }

    public static Mail randomMail(){
        Mail m = new Mail();
        m.generalDelivery = EnumClass.randomEnum(GeneralDelivery.class);
        m.scannability = EnumClass.randomEnum(Scannability.class);
        m.readability = EnumClass.randomEnum(Readability.class);
        m.address = EnumClass.randomEnum(Address.class);
        m.returnAddress = EnumClass.randomEnum(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count){
        return new Iterable<Mail>() {
            int n = count;
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    public boolean hasNext() {
                        return n-->0;
                    }

                    public Mail next() {
                        return randomMail();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("删除邮件还没实现呢");
                    }
                };
            }
        };
    }
}