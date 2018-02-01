package junit;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Son extends Father {
    private List<String> list = new ArrayList<String>();

    public void say() {
        System.out.println("D" + list.hashCode());
        sayA();
    }

    public static class Json {
        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        private int a;

        public int getB() {
            return b;
        }

        @Override
        public String toString() {
            return "Json{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }

        public void setB(int b) {
            this.b = b;
        }

        private int b;

    }

    public static void main(String[] args) throws IOException {
        Map<String, Object> map = new HashMap<>();

        map.put("AAA", "jjj");
        Json json1 = new Son.Json();
        json1.setA(1);
        json1.setB(2);
        Json json2 = new Son.Json();
        json1.setA(2);
        json1.setB(3);
        List<Json> list = new ArrayList();
        list.add(json1);
        list.add(json2);
        map.put("BB", list);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(map));
        System.out.println(mapper.writeValueAsString(list));


    }
}
