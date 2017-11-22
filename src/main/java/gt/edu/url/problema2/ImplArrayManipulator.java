package gt.edu.url.problema2;

import gt.edu.url.problema3.LeakyStack;
import java.util.List;
import java.util.*;

public class ImplArrayManipulator<E> implements ArrayManipulator<E>  {


	@Override
	public int subsets(List<E> set) {
		return 0;
	
	}
	// se obtienen los datos a ser ordenados
	public static <E> Set<Set<E>> findPowerSet(Set<E> set){
        Set<Set<E>> ret = new HashSet<Set<E>>();
        ret.add(set);
        if(set.isEmpty()){
            return ret;
        }
        Iterator<E> it = set.iterator();
        while(it.hasNext()){
            Set<E> tmp = new HashSet<E>(set);   //crea copia del set
            tmp.remove(it.next());              //remueve el siguiente del set
            ret.add(tmp);                       //agrega el temporario para el set
            ret.addAll(findPowerSet(tmp));      //recusividad
        }
        return ret;
    }
	//el main donde se le brindaran los datos para que hagan todas las posibles combinaciones
    public static void main(String[] args) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');set.add('b');set.add('c');
        System.out.println("Input set");        printSet(set);
        System.out.println("\nsub sets");
        findPowerSet(set).stream().forEach(ImplArrayManipulator::printSet);
    }
    
    //impreme las combinaciones
    public static <E> void printSet(Set<E> set){
        StringBuilder sb = new StringBuilder(set.size()==0 ? "{}\n" :"{");
        Iterator<E> it = set.iterator();
        while(it.hasNext()){
            sb.append(it.next().toString())
            .append(it.hasNext()? ", " : "}\n");
        }
        System.out.print(sb.toString());
    }
}
