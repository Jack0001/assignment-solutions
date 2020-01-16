/**
 * Trees without explicit links.
 * Notice that various fields/methods have the protected modifier
 * when normally they would/should be private.
 * The reason is that this supports whitebox testing.
 *
 * @author Stefan Kahrs
 * @version 1
 */
//note the constraint on A is a slight generalisation of A extends Comparable<A>
//and is generally recommended when one wants a comparison operation
//it basically allows that the comparison op is implemented at a supertype
//of A, instead of A itself;
//for the assessment itself it makes no discernable difference
public class LinklessTree<A extends Comparable<? super A>>
{
    //sizes of subtrees at that node index
    protected int[] sizes = {6, 2, 3, 1, 0, 1, 1};
    protected Object[] elems = { 6, 4, 9, 2, null, 7, 41};
    //for annoying technical reason this has to be an array of objects

    /**
     * Constructor for objects of class LinklessTree
     */
    private static final int STARTSIZE=15;

    public LinklessTree()
    {
        //assert STARTSIZE>0;
        //elems = freshElemArray(STARTSIZE);
        //sizes = new int[STARTSIZE];
        //sizes[0]=0;
    }

    //size of whole tree is the size of the subtree rooted at 0
    public int size() {
        return getSize(0);
    }

    public A getValue(int index) {
        return (A)elems[index];
    }

    //auxiliary methods to index the arrays out of bounds too
    //they may help to reduce case distinctions
    protected A getKey(int subtree) {
        if (subtree>=elems.length) return null; // out of bounds
        return getValue(subtree);
    }

    protected int getSize(int subtree) {
        if (subtree>=elems.length) return 0; // out of bounds
        return sizes[subtree];
    }

    //encapsulates the cast on the allocation
    protected Object[] freshElemArray(int capacity) {
        return new Object[capacity];
    }

    //remainder needs to be modified

    //find index position of val in tree, if there, or where it goes, if not there
    protected int findIndex(A val) {
        //loop through the tree, updating the i values according to left and right traversal
        for (int i = 0; i < elems.length;)
        {
            //if the value in the tree at this point is null then this is val's place 
            if(elems[i] == null){return i;};    

            //compare the val against the value in that index of the tree
            //0 is returned for the same values, -1 is val is smaller and 1 if bigger
            int compare = val.compareTo(getValue(i));

            //if they are the same return, otherwise update i for left/right
            if(compare == 0){return i;}
            else if(compare == -1){i = (2*i) + 1;}
            else{i = (2*i) + 2;}
        }

        //return -1 if a place for the value cannot be found
        return -1; 
    }

    //is value in tree
    public boolean contains(A val) {
        //run find index function on the given value to find if it is in the tree and where it would go
        int index = findIndex(val);

        //return if the index value is not -1 (not in the tree) and the value in the returned index is the same as the val entered
        return index != -1 && val == elems[index]; 
    }

    //grow the space in which we can place the tree, so that at least one insertion will succeed
    protected void grow() 
    {
        //simple grow method for doubling the sizes of the arrays
        //create the new arrays for assignment later
        Object newElems[] = new Object[elems.length*2+1];
        int newSizes[] = new int[sizes.length*2+1];

        //since the sizes are linked to each other, they can be updated at the same time
        for (int i = 0; i < elems.length && i < sizes.length; i++)
        {
            newElems[i] = elems[i];
            newSizes[i] = sizes[i];
        }

        //make the old arrays copys of the new one
        elems = newElems;
        sizes = newSizes;
    }

    //fetch the i-th element, in comparsion order
    public A get(int i)
    { 
        //check to see if the input i is larger than the trees size
        if(i >= sizes[0]){return null;}

        //traverse through the tree to fetch the wanted element
        for (int j = 0; j < sizes.length;)
        {
            //check to see if the left side of the current node is in bounds, if it isnt we are in a leaf node with no left or right tree, so assume the value is correct
            if(j*2+1 < sizes.length)
            {
                //get the sizes value of the node to the left of the current index j
                int left = sizes[j*2+1];

                //if i is smaller than left, we need to go down the left hand side of the tree
                if(i < left) {j = j*2+1;}
                //if they are the same, then return the value
                else if(i == left) {return getValue(j);}
                //if i is greater than left, go down the right side of the tree and adjust the i value accordingly
                else if(i > left) {j = j*2+2; i-=(left+1);}
            }
            else{return getValue(j);}
        }

        return null;
    }

    //add x to tree, return true if tree was modified
    //we do not allow multiple copies of the equal objects in tree
    //equality is decided by using compareTo
    public boolean insert(A x)
    { 
        //if the tree contains the value already, then the tree doesnt need to be modified
        if(contains(x)){return false;}      

        //contains the index of where the value would go if we were to put it in the tree
        int index = findIndex(x);

        //if the findIndex returns -1, then it wont fit in the tree so the tree needs to grow and the function for findIndex recalled
        if(index == -1){grow(); index = findIndex(x);}

        //change the content of the elems array at the index it should go to be x, also update its size to be one as it is no longer null
        elems[index] = x;
        sizes[index] = 1;

        //update the sizes array by moving up the tree from the index entered and updating the sizes of the parent nodes
        int i = index; 
        while (i>0)
        {           
            i = (i-1)/2;
            sizes[i] = sizes[i]+1;
        }  
        
        //if successful, return true to show the tree has been modified
        return true; 
    }

    //remove x from tree, return true if tree was modified
    public boolean delete(A x)
    { 
        //if the value is not in the tree there is nothing to be deleted, so return false
        if(!contains(x)){return false;}

        //get the index of the value and size of the node that is to be deleted from the array
        int index = findIndex(x);       
        int size = getSize(index);

        //if the size is not 1 (greater than) then the element needs to be deleted with consideration of its child nodes
        if (size != 1)
        {
            A temp;
            //if the left tree is bigger, then accomodate for the tree using the largest value in the left tree
            if(getSize(index*2+1) > getSize(index*2+2))
            {
                temp = deleteLargest(index*2+1);                
            }
            //otherwise, accomodate for the tree using the smallest value in the right tree
            else
            {
                temp = deleteSmallest(index*2+2);                
            }
            elems[index] = temp;
        }
        //if the size is 1, then there are no children to worry about and the node can be deleted by changing the size to 0 and value to null
        else
        {
            elems[index] = null;
            sizes[index] = 0;
        }

        //adjust for the new tree by changing the sizes of the updated tree
        int i = index; 
        while (i>0)
        {           
            i = (i-1)/2;
            sizes[i] = sizes[i]-1;
        }

        return true; 
    }

    //not requested, but these might be useful auxiliary ops for delete
    private A deleteLargest(int subtree) 
    { 
        for (int i = subtree; i < elems.length;)
        {     
            //if the size of the node is one or the node to the right of it is null then we have the node that is largest and can begin deleting it
            //must accomodate for any changes that may need to be made to the subtree of the node because of deletion, thus a recursive call is made
            //return temp to the original delete call to complete deletion of the original node
            if (getSize(i) == 1 || elems[i*2+2] == null)
            {
                A temp = getValue(i);
                delete(temp);
                return temp;
            }
            //otherwise continue down the right tree
            else
            {
                i = i*2+2;
            }

        }
        //cant be reached
        return null; 
    }

    private A deleteSmallest(int subtree)
    { 
        for (int i = subtree; i < elems.length;)
        {     
            //if the size of the node is one or the node to the left of it is null then we have the node that is smallest and can begin deleting it
            //must accomodate for any changes that may need to be made to the subtree of the node because of deletion, thus a recursive call is made
            //return temp to the original delete call to complete deletion of the original node
            if (getSize(i) == 1 || elems[i*2+1] == null)
            {
                A temp = getValue(i);
                delete(temp);
                return temp;
            }
            else
            //otherwise continue down the right tree
            {
                i = i*2+1;
            }

        }
        //cant be reached
        return null; 
    }
    
}