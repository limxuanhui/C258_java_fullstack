package L10.mycollection;
/* Created by limxuanhui on 17/6/22 */

// wrapper classes --> int --> primitive integer
public class TestCollection8 {

    public static void main(String[] args) {
//        Integer obj = new Integer(10);

        // Boxing -- behind the scenes putting primitive inside object
        Integer obj = 10;
        System.out.println(obj);

        // Unboxing -- behind the scenes unwrap primitive from object

        // Autoboxing  Unwrap (unbox) primitive from object,
        //             increase it, then box it into object again
        obj++;
        System.out.println(obj.intValue());

        // Boxing and unboxing

    }
}
