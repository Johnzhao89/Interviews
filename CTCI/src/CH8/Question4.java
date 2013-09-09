package CH8;
/**
 * Design a parking lot using object-oriented principles.
 * @author heguangliu
 * 
 */
import java.util.*;
class ParkingLot{
	private Level[] levels;
	private final int NUM_LEVELS =5;
	public boolean parkVehicle(Vehicle vehicle){}
}
class Level{
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots =0;
	private static final int SPOTS_PER_ROW =10;
	public Level(int flr, int numberSpots){}
	public int availableSpots(){}
	public boolean parkVehicle(Vehicle vehicle){}
	private boolean parkAtSpot(int spotNumber,Vehicle vehicle){}
	private int findAvailableSpots(Vehicle vehicle){}
}
class ParkingSpot{
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	public ParkingSpot(Level lvl, int r, int n, VehicleSize vs){}
	public boolean isAvailable(){}
	public boolean canFitVehicle(Vehicle vehicle){}
	public boolean park(Vehicle v){}
	public int getRow(){}
	public int getSpotNumber(){}
	public VehicleSize getSize(){}
	public void removeVehicle(){}
}
abstract class Vehicle{
	protected ArrayList<ParkingSpot> parkingSpots;
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;
	public int getSpotsNeeded(){}
	public VehicleSize getSize(){}
	public void parkInSpot(ParkingSpot spot){}
	public void clearSpots(){}
	public abstract boolean canFitInSpot(ParkingSpot spot);
}
enum VehicleSize{ Motorcycle,Compact, Large}
class Car extends Vehicle{
	public Car(){
		spotsNeeded =1;
		size=VehicleSize.Compact;
	}
	public boolean canFitInSpot(ParkingSpot spot){
		return spot.getSize()== VehicleSize.Large|| spot.getSize() == VehicleSize.Compact;
	}
}
class Bus extends Vehicle{
	public Bus(){spotsNeeded = 5; size = VehicleSize.Large;}
	public boolean canFitInSpot(ParkingSpot spot){}
}

public class Question4{
	
}