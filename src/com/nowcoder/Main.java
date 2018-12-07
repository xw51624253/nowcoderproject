package com.nowcoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void print(int index, Object obj){
        System.out.println(String.format("{%d}, %s",
                index, obj.toString()));
    }

    public static void demoOperation(){
        print(1, 5 / 2.0);
        print(2, 5 + 2);
        print(3, 5 - 2);
        print(4, 5 * 2);
        print(5, 5 << 2);
        print(6, 5 >> 2);
        print(7, 5 & 2);
        print(8, 5 | 2);
        print(9, 5 ^ 2);
        print(10, 5 == 2);
        print(11, 5 != 2);
    }

    public static void  demoControlFlow(){
        int score = 65;
        if (score > 80) {
            print(1, "A");
        }else if (score > 60){
            print(2, "B");
        }else {
            print(3, "C");
        }

        String garde = "B";
        switch (garde) {
            case "A":
                print(4, "score >80");
                break;
            case "B":
                print(5, "(60,80)");
                break;
            default:
                print(6, "(0, 60)");
        }

        for (int i=1; i<6; i++){
            if (i == 1){
                continue;
            }
            if (i == 5){
                break;
            }
            if (i % 2 == 1 ){
                print(8, "i%2 = 1");
            }
            print(7, i);
        }

        String str = "hello";
        for(char c : str.toCharArray()){
            print(7, c);
        }

        int target = 20;
        int current = 0;
        while (current <target){
            current += 5;
            print(10, current);
            if (current == 10){
                break;
            }
        }


    }

    public static void demoString() {
        String str = "hello nowcoder";
        print(1, str.indexOf("e"));
        print(2, str.charAt(6));//返回指定索引处的 char 值
        print(3, str.codePointAt(1));//返回指定索引处的字符（Unicode 代码点）。
        print(4, str.compareTo("hello mowcoder"));//按字典顺序比较两个字符串
        print(5, str.compareTo("hello po2coder"));
        print(6, str.compareToIgnoreCase("Hello Nowcoder"));//按字典顺序比较两个字符串,不考虑大小写
        print(7, str.concat("!!"));//将指定字符串连接到此字符串的结尾。
        print(8, str.contains("hello"));//当且仅当此字符串包含指定的 char 值序列时，返回 true。
        print(9, str.endsWith("xowcoder"));//测试此字符串是否以指定的后缀结束。
        print(10, str.startsWith("hello"));//测试此字符串是否以指定的前缀开始。
        print(11, str.lastIndexOf("o"));//返回指定子字符串在此字符串中最右边出现处的索引。
        print(12, str.toUpperCase());//将此 String 中的所有字符都转换为大写。
        print(13, str.replace('0', 'a'));
        print(14, str.replaceAll("o|l", "a"));
        print(15, str.replaceAll("hello", "hi"));

        StringBuilder sb = new StringBuilder();
        sb.append(true);
        sb.append(1);
        sb.append(2.2);
        print(16, sb.toString());
        print(17, "a" + "b" + String.valueOf(12));

    }

    public static void demoList(){
        List<String> strList = new ArrayList<String>();
        for (int i=0; i<4; ++i){
            strList.add(String.valueOf(i));
        }

        print(1, strList);

        List<String> strListB = new ArrayList<String>();
        for (int i=0; i<4; ++i){
            strListB.add(String.valueOf(i*i));
        }

        strList.addAll(strListB);
        print(2, strList);
        strList.remove(0);
        print(3, strList);
        strList.remove(String.valueOf(1));
        print(4, strList);
        print(5, strList.get(1));
        Collections.sort(strList);
        print(6, strList);

        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        print(7, strList);

        Collections.reverse(strList);
        print(8,strList);

        int[] array = new int[]{1,2,3};
        print(9, array[1]);

    }

    public static void demoSet() {
        Set<String> strSet = new HashSet<String>();
        for (int i=0; i<3; ++i) {
            strSet.add(String.valueOf(i));
        }
        print(1, strSet);
        strSet.remove("1");
        print(2, strSet);
        strSet.contains(4);
    }

    public static void demoKeyValue() {
        Map<String, String> map = new HashMap<>();
        for (int i=0; i<4; ++i){
            map.put(String.valueOf(i), String.valueOf(i*i));
        }
        print(1, map);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            print(2, entry.getKey() + ":" + entry.getValue());

        }
        print(3, map.keySet());
        print(4, map.values());
        print(5, map.containsKey("2"));
        print(6, map.get("2"));
        map.replace("1", "A");
        print(7, map);

    }

    public static void demoException() {
        try {
            print(1, "hello");
            String a = null;
            a.indexOf('a');
        }catch (NullPointerException npe) {
            print(3, "NPE");
        }catch (Exception e) {
            print(4, "Exception");
        }finally {
            print(2, "finally");
            //做清理工作
        }
    }

    public static void demoCommon() {

        Random random = new Random();
        for (int i=0; i<4; ++i) {
            print(1, random.nextInt(100));
            print(2, random.nextDouble());
        }
        List<Integer> array = Arrays.asList(new Integer[]{1,2,3,4,5});
        print(3, array);
        Collections.shuffle(array);
        print(4, array);

        Date date = new Date();
        print(5, date);
        print(6, date.getTime());//从1970年1月1号00点的时间差
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        print(7, df.format(date));
        print(8, DateFormat.getDateInstance(DateFormat.FULL).format(date));
        //习题,已知今天日期,计算未来的时间,星期几

        print(9, UUID.randomUUID());
        print(10, Math.max(1, 2));
        print(11, Math.ceil(2.2));
        print(12, Math.floor(2.2));
        print(13, Math.log(2.72));

    }

    public static void demoClass() {

        Animal animal = new Animal("Jim", 18);
        animal.say();
        animal = new Human("Lei", 11, "CN");
        animal.say();

    }

    public static void main(String[] args) {
        // write your code here
        //System.out.print("hello nowcoder");
        //print(1, "hello nowcoder");

        //demoOperation();
        //demoControlFlow();

        //demoString();

        //demoList();

        //demoSet();

        //demoKeyValue();

        //demoException();

        //demoCommon();

        demoClass();

    }
}
