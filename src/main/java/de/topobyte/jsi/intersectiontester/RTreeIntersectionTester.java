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
import com.infomatiq.jsi.rtree.RTree;
import com.infomatiq.jsi.rtree.Traversal;
import com.infomatiq.jsi.rtree.TreeTraverser;
import com.slimjars.dist.gnu.trove.procedure.TIntProcedure;

/**
 * An implementation of {@link RectangleIntersectionTester} based on an
 * {@link RTree}.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class RTreeIntersectionTester implements RectangleIntersectionTester
{

	int counter = 1;
	RTree tree;

	/**
	 * Create an intersection tester with an internal {@link RTree} that is
	 * created using the {@link RTree#RTree(int, int)} constructor with
	 * arguments 1 and 10 for min and max nodes.
	 */
	public RTreeIntersectionTester()
	{
		this(1, 10);
	}

	/**
	 * Create an intersection tester with an internal {@link RTree} that is
	 * created using the {@link RTree#RTree(int, int)} constructor with the
	 * specified values for min and max nodes.
	 */
	public RTreeIntersectionTester(int minNodeEntries, int maxNodeEntries)
	{
		tree = new RTree(minNodeEntries, maxNodeEntries);
	}

	/**
	 * Create an intersection tester using the the specified {@link RTree} for
	 * storing the covered regions. This will traverse all entries stored in the
	 * specified tree initially to determine the highest id already used.
	 * 
	 * @param tree
	 *            the rectangle tree to store covered regions in
	 */
	public RTreeIntersectionTester(RTree tree)
	{
		this.tree = tree;

		Traversal traversal = new Traversal() {

			@Override
			public void node(Rectangle rectangle)
			{
				// ignore
			}

			@Override
			public void element(Rectangle rectangle, int nodeId)
			{
				if (nodeId >= counter) {
					counter = nodeId + 1;
				}
			}

		};

		TreeTraverser traverser = new TreeTraverser(tree, traversal);
		traverser.traverse();
	}

	@Override
	public void add(Rectangle r, boolean clone)
	{
		if (clone) {
			r = new Rectangle(r.minX, r.minY, r.maxX, r.maxY);
		}
		tree.add(r, counter++);
	}

	boolean free = true;

	@Override
	public boolean isFree(Rectangle rectangle)
	{
		free = true;

		tree.intersects(rectangle, new TIntProcedure() {

			@Override
			public boolean execute(int id)
			{
				free = false;
				return false;
			}

		});

		return free;
	}

}
