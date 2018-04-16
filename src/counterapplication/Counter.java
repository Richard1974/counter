/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterapplication;

/**
 * Counts the number of sheep through a gate.
 */
class Counter {
  
  /**
   * The actual number of sheep.
   */
  private int count;
  
  /**
   * Create a new counter with its count 
   * initialised to zero.
   */
  public Counter() {
    this.reset();
  }
  
  /**
   * Reset the count to zero.
   */
  public void reset() {
    this.count = 0; 
  }
  
  /**
   * Add one to the count.
   */
  public void increment() {
    this.count++;
  }
  
  /**
   * Return the current count.
   * @return The current value of the counter.
   */
  public int getCount() {
    return this.count;
  }
  
}