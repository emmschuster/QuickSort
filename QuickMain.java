public class QuickMain {

	public static void main(String[] args) {
		int[] mlist= {6,5,3,1,4,2,2,8,7};
		System.out.println("Anfangsarray: ");
		show(mlist);
		int laenge = mlist.length;
		quicks(mlist,0,(laenge-1));
		System.out.println("Endzustand: ");
		show(mlist);
	}
	/*if __name__ == "__main__":
    mlist = [6,5,3,1,4,2,2,8,7]
    print('anfangszustand', mlist)
    quick_sort(mlist, 0, len(mlist)-1)
    print('endzustand', mlist)*/

	private static void show(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]+"    ");
		}
		System.out.println("");
	}
	/*def quick_sort(array, start, end):
    if start >= end:
        return
         
    p = partition(array, start, end)
    print('Teilung bei index', p)
    quick_sort(array, start, p-1)
    quick_sort(array, p+1, end)*/
	
	private static void quicks(int[] array, int start, int end){
		if(start >= end) {
			return;
		}
		//darf i da p schu deklarieren oder soll i des aussen machen?
		int p= partition(array, start, end);
		System.out.println("Teilung bei Index : "+p);
		quicks(array, start, p-1);
		quicks(array, p+1, end);
	}
	
	private static int partition (int[] array, int start, int end){
		int pivot=array[start];
		int low = start +1;
		int high=end;
		//boolean x=true;
		while(true) {
			while (low<=high && array[high]>= pivot) {
				high-=1;
			}
			while (low<=high && array[low]<= pivot) {
				low+=1;
			}
			if (low <= high) {
				array[low] = array[high];
				array[high] = array[low];
			} else {
				System.out.print("low berührt high break");
				break;
			}
		}
		array[start]=array[high];
		array[high]=array[start];
		System.out.println("vertausche pivot mit high stelle");
		show(array);
		return high;
	}		
}
/*
def partition(array, start, end):
    pivot = array[start]
    low = start + 1
    high = end
 
    while True:
        # If the current value we're looking at is larger than the pivot
        # it's in the right place (right side of pivot) and we can move left,
        # to the next element.
        # We also need to make sure we haven't surpassed the low pointer, since that
        # indicates we have already moved all the elements to their correct side of the pivot
        while low <= high and array[high] >= pivot:
            high = high - 1
 
        # Opposite process of the one above
        while low <= high and array[low] <= pivot:
            low = low + 1
 
        # We either found a value for both high and low that is out of order
        # or low is higher than high, in which case we exit the loop
        if low <= high:
            array[low], array[high] = array[high], array[low]
            print('passende zahlen gefunden, low=', low, 'high=', high)
            print(array)
            # The loop continues
        else:
            # We exit out of the loop
            print('low berührt high break')
            break
 
    array[start], array[high] = array[high], array[start]
    print('vertausche pivot mit high stelle')
    print(array)
 
    return high
    
*/