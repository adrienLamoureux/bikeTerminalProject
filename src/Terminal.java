/**
 * 
 */
package src;

import java.util.ArrayList;
import java.util.List;

/**
 *	TODO
 *	ajout d'emplacement = addSize(number){size += number}
 *	+ suppression d'emplacement
 *	Tenir compte de la size lors de l'ajout d'un velo (bloquer)
 *	Rajouter des tests !!
 *
 */
public class Terminal {
	
	private List<Bike> bikeList;
	
	// Default capacity of every terminal
	private int size = 10;
	// Gestion des emplacements max: size
	// Faire ajout et suppression d'emplacement
	
	public Terminal() {
		// init with new ArrayList<Bike>(size);
		this.bikeList = new ArrayList<Bike>(size);
	}
	
	public Terminal(List<Bike> bikeList) {
		this.bikeList = bikeList;
	}
	
	public List<Bike> getBikeList() {
		return this.bikeList;
	}
	
	public boolean containsBike(Bike bike) {
		// Call the bottom one
		return this.containsBike(bike.getId());
	}
		
	public boolean containsBike(int id) {
		return this.indexOfById(id) == -1 ? false : true;
	}
	
	public void addBike(Bike bike) {
		// Attention, gestion du nombre de velo par rapport a emplacement
		// if size == this.bikeList.size(), bloquer l'ajout d'un velo 
		// (plus de places de dispo dans le terminal donc on ne peut pas ajouter un velo)
		this.bikeList.add(bike);
	}
	
	public boolean removeBike(Bike bike) {
		// Call the bottom one
		return this.removeBike(bike.getId());
	}
	
	public boolean removeBike(int id) {
		int index = this.indexOfById(id);
		if(index == -1) {
			return false;
		}
		this.bikeList.remove(index);
		return true;
	}
	
	private int indexOfById(int id) {
		for(int i=0; i<this.bikeList.size(); ++i) {
			if(id == this.bikeList.get(i).getId()) {
				return i;
			}
		}
		return -1;
	}
}
