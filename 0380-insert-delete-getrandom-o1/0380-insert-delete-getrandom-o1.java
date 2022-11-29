import java.util.Random;
class RandomizedSet {

    Set<Integer> set;
    Random rand = new Random();
    
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
        
    }
    
    public int getRandom() {
        List<Integer> lst=new ArrayList<>(set);
        return lst.get(rand.nextInt(lst.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */