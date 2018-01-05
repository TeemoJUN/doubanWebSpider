package junit;

import java.util.ArrayList;
import java.util.List;

public class Father {
    private List<String> list=new ArrayList<String>();
    public void sayA(){
        say();
        System.out.println("A"+list.hashCode());
    }
    protected void say(){
        System.out.println("B"+list);
    }
    public void addList(){
        list.add("D");
    }
    public int getSize(){
        return list.size();
    }
}
