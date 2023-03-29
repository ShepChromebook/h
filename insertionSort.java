/*
A superclass
2 subclasses that extend the superclass
A constructor in a subclass that uses the super() constructor
A method in a subclass that is inherited, and not overridden
A method in each subclass that overrides the parent class method
A method in a subclass that overrides the parent class method but also calls the parent class method using the super. keyword.
Client code (aka, a class that is not a subclass or parent class) that creates an ArrayList, or Array of parentclass objects. Fill the Array or ArrayList with at least 2 objects from each class.  It then uses a loop to call a method that has been overridden in each of the subclasses, and print some result to the console
Each class must have a toString method (can be inherited) and an equals method (can be inherited)
*/
class Animation {
    private String title;
    private int views;
    
    Animation(String t, int v) {
        title = t;
        views = v;
    }

    public void OverrideMe() {
        System.out.println("Super!");
    }
}
class AnimatedMovie extends Animation {
    private String director;
    AnimatedMovie(String t, int v, String d) {
        super(t,v);
        director = d;
    }
    @Override
    public void OverrideMe() {
        System.out.println("Child!");
    }
}
class Client {
    public static void main(String[] args) {
        Animation anime = new AnimatedMovie("Spirit", 0, "Joe M.");
        
        anime.OverrideMe();
    }
}