package wj.test;

import org.junit.Test;
import wj.other.Employee;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by WangJie on 2018/5/21.
 */
public class StreamTest {

    public static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("测试1", 27, "001", 5000, "销售部"));
        employees.add(new Employee("测试2", 30, "002", 6000, "销售部"));
        employees.add(new Employee("测试3", 20, "003", 7000, "销售部"));
        employees.add(new Employee("测试4", 28, "004", 9000, "开发部"));
        employees.add(new Employee("测试5", 26, "005", 9000, "开发部"));
        Employee e = new Employee("测试6", 40, "006", 6000, "采购部");
        employees.add(e);
//        employees.add(e);
    }

    @Test
    public void test() {
//        employees.stream().filter(employee -> employee.getAge() > 28).forEach(System.out::println);
        Optional<Employee> first = employees.stream().filter(employee -> "004".equals(employee.getNo())).findFirst();
        Employee o = null;
        if (first.isPresent()) {
            o = first.get();
            System.out.println(o);
        }else{
            System.out.println("hase no");
        }
        LinkedList<Employee> h = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            h.offer(next);
            if(h.contains(o)){
                System.out.println(o);
                break;
            }
        }
    }


    //1. 创建 Stream
    @Test
    public void test1() {
        //1. Collection 提供了两个方法  stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        //4. 创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(1, (x) -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        //生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);

    }

    /*
      筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

    //内部迭代：迭代操作 Stream API 内部完成
    @Test
    public void test2() {
        //所有的中间操作不会做任何的处理
        Stream<Employee> stream = employees.stream()
                .filter((e) -> e.getAge() >= 35);

        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
        System.out.println("==========limit===============");
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("==========skip================");
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("==========distinct============");
        employees.stream().distinct().forEach(System.out::println);


    }

    //2. 中间操作
    /*
        映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */
    @Test
    public void test3() {
        Stream<String> str = employees.stream()
                .map((e) -> e.getName());
        str.forEach(System.out::println);
        System.out.println("-------------------------------------------");

        int sum = employees.stream().mapToInt(Employee::getAge).sum();
        System.out.println(sum);
        System.out.println("-------------------------------------------");

        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        Stream<String> stream = strList.stream().map(String::toUpperCase);
        stream.forEach(System.out::println);
        System.out.println("-------------------------------------------");

        Stream<Stream<Character>> stream2 = strList.stream()
                .map(StreamTest::filterCharacter);

//        stream2.forEach(System.out::println);
        stream2.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("---------------------------------------------");

        Stream<Character> stream3 = strList.stream()
                .flatMap(StreamTest::filterCharacter);

        stream3.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /*
    sorted()——自然排序
    sorted(Comparator com)——定制排序
 */
    @Test
    public void test4() {
        Stream<Double> sorted = employees.stream()
                .map(Employee::getSalary)
                .sorted();
        sorted.forEach(System.out::println);
        //终止操作后不能重复使用stream
//        sorted.forEach(System.out::println);

        System.out.println("------------------------------------");

        employees.stream()
                .sorted((x, y) -> {
                    if (x.getSalary() == y.getSalary()) {
                        return Integer.compare(x.getAge(), y.getAge());
                    } else {
                        return Double.compare(x.getSalary(), y.getSalary());
                    }
                }).forEach(System.out::println);
    }

    //3. 终止操作
    /*
        allMatch——检查是否匹配所有元素
		anyMatch——检查是否至少匹配一个元素
		noneMatch——检查是否没有匹配的元素
		findFirst——返回第一个元素
		findAny——返回当前流中的任意元素
		count——返回流中元素的总个数
		max——返回流中最大值
		min——返回流中最小值
	 */
    @Test
    public void test5() {
        boolean bl = employees.stream()
                .allMatch((e) -> e.getSalary() > 3000);

        System.out.println(bl);

        boolean bl1 = employees.stream()
                .anyMatch((e) -> e.getSalary() > 6000);

        System.out.println(bl1);

        boolean bl2 = employees.stream()
                .noneMatch((e) -> e.getSalary() > 3000);

        System.out.println(bl2);
        System.out.println("------------------------------------");
        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();

        System.out.println(op.get());

        System.out.println("--------------------------------");

        Optional<Employee> op2 = employees.parallelStream()
                .filter((e) -> e.getSalary() > 6000)
                .findAny();

        System.out.println(op2.get());

        System.out.println("--------------------------------");

        long count = employees.stream()
                .filter((e) -> e.getSalary() > 8000)
                .count();

        System.out.println(count);

        Optional<Double> opMax = employees.stream()
                .map(Employee::getSalary)
                .max(Double::compare);

        System.out.println(opMax.get());

        Optional<Employee> opMin = employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        System.out.println(opMin.get());
    }

    //3. 终止操作
    /*
        归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    @Test
    public void test6() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);
        Optional<String> opStr = list.stream().map(String::valueOf).reduce((s, s2) -> s + "," + s2);
        System.out.println(opStr.get());

        System.out.println("----------------------------------------");

        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);

        System.out.println(op.get());
    }


    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    @Test
    public void test7() {
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("----------------------------------");
        //新建集合
        HashSet<String> hs = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);

        System.out.println("----------------------------------");
        //加入已有集合
        List<String> newList = new ArrayList<>();
        newList.add("test");
        List<String> list1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(() -> newList));
        list1.forEach(System.out::println);

    }

    @Test
    public void test8() {
        Optional<Double> max = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        Optional<Employee> op = employees.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

        System.out.println(op.get());

        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println(sum);

        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avg);

        Long count = employees.stream()
                .collect(Collectors.counting());

        System.out.println(count);

        System.out.println("--------------------------------------------");

        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getMax());
    }

    //分组分区
    @Test
    public void test9() {
        //分组
        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        System.out.println(map);

        System.out.println("------------------groupingBy--------------------------");
        //分组后计算个数
        Map<String, Long> map1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

        System.out.println(map1);

        System.out.println("-----------------groupingBy----summing-----------------------");
        //分组后计算和
        Map<String, Integer> map3 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.summingInt(value -> value.getAge())));

        System.out.println(map3);
        System.out.println("---------------groupingBy-------joining----------------------");
        //分组后,名字串联
        Map<String, String> map4 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(Collectors.toList(), employees1 -> employees1.stream().map(Employee::getName).collect(Collectors.joining("-")))));

        System.out.println(map4);


        System.out.println("-------------------partitioning-------------------------");
        //分区
        Map<Boolean, List<Employee>> map2 = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 8000));

        System.out.println(map2);

        System.out.println("------------------joining--------------------------");
        //字符串连接
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));

        System.out.println(str);
        System.out.println("--------------------reducing------------------------");
        //归约
        Optional<Double> sum = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));

        System.out.println(sum.get());
    }

    //并行流
    @Test
    public void test10() {
        List<Integer> list = new ArrayList<>();
        // 将10000-1存入list中
        for (int i = 100000; i >= 1; i--) {
            list.add(i);
        }
        ;
        long begin = System.currentTimeMillis();
        list.stream().mapToInt(value -> value).sum();
        long end = System.currentTimeMillis();
        System.out.println("顺序流时间：" + (end - begin));

        long begin1 = System.currentTimeMillis();
        list.parallelStream().mapToInt(value -> value).sum();
        long end1 = System.currentTimeMillis();
        System.out.println("并行流时间：" + (end1 - begin1));
    }

    @Test
    public void test11() {
        Class<TestUtil> utilClass = TestUtil.class;
        try {
            Constructor<TestUtil> constructor = utilClass.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            TestUtil util = constructor.newInstance(null);
            System.out.println(util.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
