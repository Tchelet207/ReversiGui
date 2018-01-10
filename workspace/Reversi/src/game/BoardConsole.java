package game;

import java.util.ArrayList;

/*
 * Naama Harshoshanim
 * 315783217
 * Tchelet Englmans
 * 208780585
 */
public class BoardConsole implements Board {
	private int size;
    private ArrayList<ArrayList<Celltype>> board;
    private int xcounter;
    private int ocounter;
    /**
     * constructor.
     * @param size
     */
    public BoardConsole(int size) {
    	this.board = new ArrayList<ArrayList<Celltype>>();
	    this.size = size;
    	for (int i = 0; i < this.size; i++) {
    		ArrayList<Celltype> arrayList = new ArrayList<Celltype>();
            for (int j = 0; j < this.size; j++) {
            	Celltype cell = new Celltype("Empty");
            	arrayList.add(cell);
            }
            this.board.add(arrayList);
        }
	    this.board.get((int)((this.size/2)-1)).get((int)((this.size/2)-1)).setCelltype("White");
	    this.board.get((int)(this.size/2)).get((int)(this.size/2)).setCelltype("White");
	    this.board.get((int)((this.size/2)-1)).get((int)(this.size/2)).setCelltype("Black");
	    this.board.get((int)(this.size/2)).get((int)((this.size/2)-1)).setCelltype("Black");
	    this.xcounter = 2;
	    this.ocounter = 2;
	}
    /**
     * constructor.
     */
    public BoardConsole() {
    	this.board = new ArrayList<ArrayList<Celltype>>();
    	this.size = 8;
    	for (int i = 0; i < this.size; i++) {
    		ArrayList<Celltype> arrayList = new ArrayList<Celltype>();
            for (int j = 0; j < this.size; j++) {
            	Celltype cell = new Celltype("Empty");
            	arrayList.add(cell);
            }
            this.board.add(arrayList);
        }
	    this.board.get((int)((this.size/2)-1)).get((int)((this.size/2)-1)).setCelltype("White");
	    this.board.get((int)(this.size/2)).get((int)(this.size/2)).setCelltype("White");
	    this.board.get((int)((this.size/2)-1)).get((int)(this.size/2)).setCelltype("Black");
	    this.board.get((int)(this.size/2)).get((int)((this.size/2)-1)).setCelltype("Black");
	    this.xcounter = 2;
	    this.ocounter = 2;
    }
    /**
     * return the board.
     * @return cellType**
     * @Override
     */
	public ArrayList<ArrayList<Celltype>> getBoard() {
	    return this.board;
	}

    /**
     * printing the board.
     * @Override
     */
	public void printBoard() {
		System.out.print(" |");
	    for (int i=1; i<size+1; i++) {
			System.out.print(" ");
			System.out.print(i);
			System.out.print(" |");
	    }
		System.out.println("");
	    for (int i=0; i<(size*4)+2; i++) {
	    	System.out.print("-");
	    }
		System.out.println("");
	    for (int i=0; i<size; i++) {
			System.out.print(i + 1);
			System.out.print("|");
	        for (int j=0; j<size; j++) {
	            if(this.board.get(i).get(j).getCelltype() == "Black") {
		            System.out.print(" X |");
	            } else if (this.board.get(i).get(j).getCelltype() == "White") {
	            	System.out.print(" O |");
	            } else {
	            	System.out.print("   |");
	            }
	        }
			System.out.println("");
	        for (int m=0; m<(size*4)+2; m++) {
		    	System.out.print("-");
	        }
			System.out.println("");
	    }		
	}
	
	/**
     * checking if the board is full.
     * @return boolean
     * @Override
     */
	public boolean ifFull() {
		boolean empty = false;
	    for (int i = 0; i < this.size; i++) {
	        for (int j = 0; j < this.size; j++) {
	            if (this.board.get(i).get(j).getCelltype() == "Empty") {
	                empty = true;
	            }
	        }
	    }
	    return !empty;
	}

	/**
     * checking who wins.
     * @Override
     * @return cellType
     */
	public Celltype whoWins() {
		int blackC = 0, whiteC = 0;
		Celltype cell = new Celltype("Empty");
	    for (int i = 0; i < this.size; i++) {
	        for (int j = 0; j < this.size; j++) {
	            if (this.board.get(i).get(j).getCelltype() == "White") {
	                whiteC++;
	            } else if (this.board.get(i).get(j).getCelltype() == "Black") {
	                blackC++;
	            }
	        }
	    }
	    if (blackC > whiteC) {
	    	cell.setCelltype("Black");
	        return cell;
	    } else if (whiteC > blackC) {
	    	cell.setCelltype("White");
	        return cell;
	    }
	    return cell;
	}

	/**
     * return the size.
     * @return size
     * @Override
     */
	public int getSize() {
		return this.size;
	}

	/**
	 * return the x counter.
	 * @return xcounter
	 */
	public int getXCounter() {
		return this.xcounter;
	}

	/**
	 * return the o counter.
	 * @return ocounter
	 */
	public int getOCounter() {
		return this.ocounter;
	}

	/**
	 * set the x counter.
	 * @param newXcounter
	 */
	public void setXCounter(int newXcounter) {
		this.xcounter = newXcounter;
	}

	/**
	 * set the y counter.
	 * @param newYcounter
	 */
	public void setOCounter(int newOcounter) {
		this.ocounter = newOcounter;
	}
}