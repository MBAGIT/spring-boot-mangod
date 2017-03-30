/**
 * 
 */
package com.bmh.coding.repository;

/**
 * To create a custom method
 * @author Mohamed
 *
 */
public interface CommandRepositoryCustom {

	/**
	 * update the valid attribute of the first command where mount greater than mont
	 * 
	 * 
	 * @param mount
	 * @param valid
	 * @return {@link Integer}
	 */
	public int updateCommand(Double mount, Boolean valid);

}
