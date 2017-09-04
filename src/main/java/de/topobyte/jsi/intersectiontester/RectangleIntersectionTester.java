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

public interface RectangleIntersectionTester
{

	public void add(Rectangle rectangle, boolean clone);

	public boolean isFree(Rectangle rectangle);

}
