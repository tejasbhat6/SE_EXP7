public class BloomFilter {
    static int bitArr[] = new int[20];
    static int k = 2;
    public static void main(String[] args) {
        // Insert 
        insert("cat");
        insert("dog");
        insert("mouse");


        // Search
        search("cat");
        search("dog");
        search("mouse");
        search("horse");

    }
    public static void search(String elem){
        int h1 = hashFunc1(elem);
        int h2 = hashFunc2(elem);
        if(bitArr[h1] == 1 && bitArr[h2] == 1){
            System.out.println("Element : " + elem + " Probably present");
        }else{
            System.out.println("Element : " + elem + " not present 100 %");
        }
    }
    public static void insert(String elem){
        int h1 = hashFunc1(elem);
        int h2 = hashFunc2(elem);
        bitArr[h1] = 1;
        bitArr[h2] = 1;
        System.out.println("Element : " + elem +" inserted successfully");
    }
    public static int hashFunc1(String elem){
        int ans = 0;
        for(int i=0 ; i < elem.length() ; i++){
            ans = ans + elem.charAt(i);
        }
        return ans % bitArr.length;
    }
    public static int hashFunc2(String elem){
        int ans = 0;
        for(int i=0 ; i < elem.length() ; i++){
            ans = ans * elem.charAt(i) + i;
        }
        return ans % bitArr.length;
    }
}