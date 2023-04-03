import java.util.Arrays;
/*
✅A superclass
    //Animation
✅2 subclasses that extend the superclass
    //AnimatedMovie, AnimatedShow
✅A constructor in a subclass that uses the super() constructor
    //Line 69
✅A method in a subclass that is inherited, and not overridden
    //Made(amount) method, Line 60
✅A method in each subclass that overrides the parent class method
    //AddWatches(n) method, lines 54, 86, 112
✅A method in a subclass that overrides the parent class method but also calls the parent class method using the super. keyword.
    //It ended up that in every situation I decided it would make sense to extend the super. method
✅Client code (aka, a class that is not a subclass or parent class) that creates an ArrayList, or Array of parentclass objects. Fill the Array or ArrayList with at least 2 objects from each class.  It then uses a loop to call a method that has been overridden in each of the subclasses, and print some result to the console

✅Each class must have a toString method (can be inherited) and an equals method (can be inherited)
 */
class Animation {
    private String name;
    private String[] animators;
    private int watches;
    private int profit;
    /**Constructs a new Animation object. Also has watches (animators*10) and profit (animators*-100) fields
     * @param name Name of the film
     * @param animators a String Array of the animators that worked on this Animation
     */
    Animation(String name, String[] animators) {
        this.name = name;
        this.animators = animators;
        this.watches = animators.length * 10;
        this.profit = animators.length * -100;
    }
    /**
     * @return Returns a string describing the Animation object, including name, animators, watches, & profit
    */
    @Override
    public String toString() {
        return String.format("%s is an Animation by %s that got %d watches, made %d profit",name, Arrays.asList(animators),watches,profit);
    }
    /** 
     * @return True if `obj` is an Animation object and `obj` has the same Name and same Animators
     * */
    @Override
    public boolean equals(Object obj) {
        Animation other = (Animation)(obj);
        return obj instanceof Animation && name.equals(other.name) && Arrays.equals(animators, other.animators);
    }
    /**
     * Note: IS overriden by child classes
     * @param n amount of watches to add to the `watches` field
     * @return Returns the new value of the `watches` field
     */
    public int AddWatches(int n) { return watches += n; }
    /**
     * Note: is NOT overriden by child classes
     * @param amount amount of profit to add to the int field `profit`
     * @return Returns the new value of the `profit` field
     */
    public int Made(int amount) { return profit += amount; }
}
class AnimatedShow extends Animation {
    private int LiveWatchers;
    /**Constructs a AnimatedShow object
     * @param name Name of the Animation
     * @param animators the animators that worked on the Animation
     * @param LiveWatchers the amount of people who watch the Show live
     */
    AnimatedShow(String name, String[] animators, int LiveWatchers) {
        super(name, animators);
        this.LiveWatchers = LiveWatchers;
    }
    /**
     * Returns the same as Animation.toString(), but adds "has N live watchers"
     */
    @Override
    public String toString() {
        return super.toString() + ", has " + LiveWatchers + " live watchers";
    }
    /**
     * Adds `casualWatches` to the field `watches`, then also adds the amount of LiveWatchers to watches 
     * @param casualWatches watches from people who are NOT liveWatchers
     * @return 
     */
    @Override
    public int AddWatches(int casualWatches) { return super.AddWatches(casualWatches + LiveWatchers); }
}
class AnimatedMovie extends Animation {
    private int ticketSales;
    /**
     * Constructs new AnimatedMovie object
     * @param name name of the Animation
     * @param animators animators who worked on the Animation
     * @param ticketSales Number of ticket sales from in-person Movie watchers
     */
    AnimatedMovie(String name, String[] animators, int ticketSales) {
        super(name, animators);
        this.ticketSales = ticketSales;
    }
    /**
     * Same as Animation.toString(), but concatenates ", sold N ticket sales" to the end
     */
    @Override
    public String toString() {
        return super.toString() + ", sold " + ticketSales + " ticket sales";
    }
    /**
     * I decided to assume that all new views are from tickets, therefore `n` is also added to the field `ticketSales`
     * @param n Amount of watches/ticket sales
     */
    @Override
    public int AddWatches(int n) { 
        ticketSales += n;
        return super.AddWatches(n);
    }
}
class Client {
    public static void main(String[] args) {
        Animation[] anis = {
                    new Animation("Hollow Myth",new String[] {"Kayu Yu","David Wu"}),
                    new AnimatedShow("The Castle",new String[] {"Wesley"}, 5000),
                    new AnimatedMovie("Facing",new String[] {"Boon"}, 3000)
                };
        for (Animation a : anis) {
            System.out.println();
            System.out.println();
            
            System.out.println(a);
            System.out.println("" + a.AddWatches(500) + " watches"); //Overriden method
            System.out.println(a + "\n and " + (a.equals(anis[0]) ? "IS " : "is NOT ") + "Hollow Myth");
        }
    }
}