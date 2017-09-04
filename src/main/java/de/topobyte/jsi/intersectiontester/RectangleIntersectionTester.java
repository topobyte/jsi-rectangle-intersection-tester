// Copyright 2017 Sebastian Kuerten
//
// This file is part of jsi-rectangle-intersection-tester.
//
// jsi-rectangle-intersection-tester is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jsi-rectangle-intersection-tester is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with jsi-rectangle-intersection-tester. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.jsi.intersectiontester;

import com.infomatiq.jsi.Rectangle;

/**
 * A data structure that stores rectangular regions and can be queried with
 * rectangles. Rectangular regions can be added via
 * {@link #add(Rectangle, boolean)} and queries can be submitted with
 * {@link #isFree(Rectangle)}. Currently the data structure does not support
 * removal operations.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public interface RectangleIntersectionTester
{

	/**
	 * Mark the specified rectangle as covered. Subsequent calls to
	 * {@link #isFree(Rectangle)} that intersect the specified rectangle will
	 * return false.
	 * 
	 * @param rectangle
	 *            the region to mark as covered
	 * @param clone
	 *            whether the argument can be stored or it should be cloned to a
	 *            new object (depends on whether you're reusing the same object
	 *            on your end)
	 */
	public void add(Rectangle rectangle, boolean clone);

	/**
	 * Query whether the specified region is free. A rectangle is free if it
	 * does not intersect any of the rectangles added to this data structure
	 * with {@link #add(Rectangle, boolean)} before.
	 * 
	 * @param rectangle
	 *            the region to test for
	 * @return whether the region does not intersect any rectangle added before.
	 */
	public boolean isFree(Rectangle rectangle);

}
