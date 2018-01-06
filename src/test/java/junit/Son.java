package junit;

import java.util.ArrayList;
import java.util.List;

public class Son extends Father{
    private List<String> list=new ArrayList<String>();
    public void say(){
        System.out.println("D" +list.hashCode());
        sayA();
    }
}
