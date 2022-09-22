/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at Dome sticatableTrader.java for an example.
 */

import java.util.List;

class DrivableTrader extends Trader<Drivable> {
    /**
     * Construct a DrivableTrader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Drivable Objects in this Trader's inventory
     * @param wishlist  Drivable Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist,
                          int money) {
        super(inventory, wishlist, money);
    }

    /**
     * Construct a DrivableTrader, giving them the
     * given money and an empty wishlist and inventory.
     *
     * @param money     The Trader's money
     */
    public DrivableTrader(int money){
        super(money);
    }

    /**
     * Iff the Object obj is Tradable, return the price of obj.
     * The price should equal the Object's price + Object's max speed.
     * If it is not Tradable, return Tradable.MISSING_PRICE
     *
     * @param obj the object whose price should be returned
     * @return the price of obj if it is Tradable, or
     * Tradable.MISSING_PRICE if it is not Tradable.
     */
    @Override
    public int getSellingPrice(Drivable obj) {
        if (obj instanceof Tradable) {
            return ((Tradable) obj).getPrice() + obj.getMaxSpeed();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }

}
