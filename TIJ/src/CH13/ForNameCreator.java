package CH13;

import java.util.*;
public class ForNameCreator extends PetCreator{
	private static List<Class<? extends Pet>> types= new ArrayList<Class<? extends Pet>>();
	private static String[] typeNames =
		{"CH13.Mutt",
		"CH13.Pug",
	    "CH13.EgyptianMau",
	    "CH13.Manx",
	    "CH13.Cymric",
	    "CH13.Rat",
	    "CH13.Mouse",
	    "CH13.Hamster"
		};
	@SuppressWarnings("unchecked")
	private static void loader(){
		try{
			for(String name: typeNames)
				types.add((Class<? extends Pet>)Class.forName(name));
		}catch(ClassNotFoundException e) {
		      throw new RuntimeException(e);
		}
	}
	static{
		loader();
	}
	public List<Class<? extends Pet>> types() 
	{return types;}
}

