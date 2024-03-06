public class test {
    public static void main(String[] args) {
        String str = "text.txt";
        int index = str.lastIndexOf(".");
        String name = str.substring(0,index);
        String ext = str.substring(index);

        System.out.println(name);
        System.out.println(ext);

        System.out.println("eee");
    }
}
