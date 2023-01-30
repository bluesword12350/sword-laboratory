package top.bluesword.laboratory;

import org.cozodb.CozoDb;

class CozoDbTest {

    public static void main(String[] args) {
        try {
            CozoDb db = new CozoDb();
            System.out.println(db.run("?[] <- [['hello', 'world!']]"));
            db.close();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
