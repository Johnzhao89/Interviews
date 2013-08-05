package CH8;

/******************
 * Exercise 14 ****************** Create three interfaces, each with two
 * methods. Inherit a new interface from each, adding a new method. Use the new
 * interface to create a class, and inherit from a concrete class. Now write
 * four methods, each of which takes one of the four interfaces as an argument.
 * Create an object of your class in main(), and pass it to each of the methods.
 ***********************************************/
interface Monster {
	void menace();
}

interface DangerousMonster extends Monster {
	void destroy();
}

interface Lethal {
	void kill();
}

interface Vampire extends DangerousMonster, Lethal {
	void drinkBlood();
}

class DragonZilla implements DangerousMonster {
	public void menace() {
	}

	public void destroy() {
	}
}

class VeryBadVampire implements Vampire {
	public void menace() {
	}

	public void destroy() {
	}

	public void kill() {
	}

	public void drinkBlood() {
	}
}

public class E14_InterfaceInheritance {
	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	static void w(Lethal l) {
		l.kill();
	}

	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}
}
