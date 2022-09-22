/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /**
     * If id does not appear as a key in drivable, add (id, obj) as a key/value pair
     * to drivable_map and return true
     *
     * @param id  the ID of this Drivable object
     * @param obj the Drivable object to be added to drivable_map
     * @return true if (id, obj) key/value pair was added to drivable_map. Otherwise, return false.
     */
    public boolean addDrivable(String id, Drivable obj) {
        if (!this.drivable_map.containsKey(id)) {
            this.drivable_map.put(id, obj);
            return true;
        }
        return false;
    }

    /**
     * Return true iff there is at least one item in drivable_map that has a MaxSpeed >= the
     * given speed
     *
     * @param speed the speed to be checked against speeds in drivable_map
     * @return true iff there is at least one item in drivable_map that has a MaxSpeed >= the
     * given speed
     */
    public boolean hasFasterThan(int speed) {
        Collection<Drivable> values = drivable_map.values();
        for (Drivable value : values) {
            if (value.getMaxSpeed() >= speed) {
                return true;
            }
        }
        return false;
    }

    /**
     * Create and return a list of all the tradable items in drivable_map
     *
     * @return an ArrayList of all the tradable items in drivable_map
     */
    public List<Tradable> getTradable() {
        List<Tradable> tradableItems = new ArrayList<>();
        Collection<Drivable> values = this.drivable_map.values();
        for (Drivable obj : values) {
            if (obj instanceof Tradable) {
                tradableItems.add((Tradable) obj);
            }
        }
        return tradableItems;
    }


}