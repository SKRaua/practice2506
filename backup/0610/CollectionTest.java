package com.cqupt.pojo;

import java.util.*;

/**
 * @author Zhou Xinyang
 */
public class CollectionTest {
    public static void main(String[] args) {
        // 初始化一个String类型的ArrayList
        // ArrayList<String> list=new ArrayList<>();
        // list.add("张三");
        // list.add("李四");
        // list.add("王五");
        // System.out.println(list);
        // list.set(0,"李华");//修改list的元素
        // System.out.println(list);
        // list.remove(2); //删除下标为2的元素
        // System.out.println(list);

        // 初始化一个Integer类型的集合
        // Set<Integer>set=new HashSet<>();
        // set.add(1);
        // set.add(1);
        // set.add(1);
        // set.add(2);
        // set.add(3);
        // System.out.println(set); //集合的元素是去重和无序的

        // 初始化一个key数字+value字符串的map
        // Map<Integer,String>map=new HashMap<>();
        // map.put(1,"张三");
        // map.put(2,"李四");
        // map.put(3,"王五");
        // System.out.println(map.get(2)+'\n'); //获取编号为2的数值 O(1)
        // map.put(2,"李华");
        // for(Map.Entry<Integer,String> entry:map.entrySet()){ //增强for循环打印所有的元素
        // System.out.println(entry.getKey()+" "+entry.getValue());
        // }
        // System.out.println();
        // for(Integer key:map.keySet()){ //可以使用keySet拿到键从而获取值
        // System.out.println(key+" "+map.get(key));
        // }

        // 链表
        // LinkedList<Integer> list=new LinkedList<>();
        // //头插法
        // list.addFirst(1);
        // list.addFirst(2);
        // list.addFirst(3);
        // System.out.println(list); //3 2 1
        // //尾插法
        // list.addLast(4);
        // list.addLast(5);
        // list.addLast(6);
        // System.out.println(list); //3 2 1 4 5 6
        // //在指定位置插入元素
        // list.add(2,7); //3 2 7 1 4 5 6
        // System.out.println(list);
        // list.removeFirst(); //移除第一个元素
        // System.out.println(list); //2 7 1 4 5 6
        // list.removeLast(); //移除最后一个元素
        // System.out.println(list); //2 7 1 4 5
        // //list.remove(); //直接remove默认移除第一个元素
        // list.remove(2); //移除指定位置的元素
        // System.out.println(list); //2 7 4 5
        // list.clear(); //清空llist
        // System.out.println(list);

        // 自定义对象的排序规则
        CollectionTest col = new CollectionTest();
        col.comparatorTest();

    }

    // 自定义集合排序规则
    public void comparatorTest() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三", 18, "男"));
        list.add(new Person("李四", 20, "男"));
        list.add(new Person("王五", 19, "男"));
        System.out.println("排序前:");
        for (Person p : list) {
            System.out.println(p.toString());
        }

        // 希望得到的排序结果是按照年龄进行排序
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge(); // o1-o2代表升序
            }
        });
        System.out.println("按照年龄排序后:================================");
        for (Person p : list) {
            System.out.println(p.toString());
        }

        System.out.println("使用小顶堆进行排序:=============================");
        // 使用优先队列（小顶堆）进行排序
        PriorityQueue<Person> queue = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        queue.offer(new Person("张三", 18, "男"));
        queue.offer(new Person("李四", 20, "男"));
        queue.offer(new Person("王五", 19, "男"));
        while (!queue.isEmpty()) { // queue不能直接遍历，需要每次弹出堆顶元素
            System.out.println(queue.poll());
        }

        System.out.println("使用大顶堆进行排序:=============================");
        // queue=new PriorityQueue<>(new Comparator<Person>() {
        // @Override
        // public int compare(Person o1, Person o2) {
        // return o2.getAge()-o1.getAge();
        // }
        // });
        queue = new PriorityQueue<>((o1, o2) -> o2.getAge() - o1.getAge()); // lambda表达式的写法
        queue.offer(new Person("张三", 18, "男"));
        queue.offer(new Person("李四", 20, "男"));
        queue.offer(new Person("王五", 19, "男"));
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
