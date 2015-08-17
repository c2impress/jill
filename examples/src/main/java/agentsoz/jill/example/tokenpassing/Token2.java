package agentsoz.jill.example.tokenpassing;

/*
 * #%L
 * Jill Cognitive Agents Platform
 * %%
 * Copyright (C) 2014 - 2015 by its authors. See AUTHORS file.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import agentsoz.jill.lang.Goal;
import agentsoz.jill.lang.GoalInfo;

@GoalInfo(hasPlans={"agentsoz.jill.example.tokenpassing.ReceiveToken2"})
public class Token2 extends Goal {

	private int round;
	private int agent;
	
	public Token2(String str) {
		super(str);
	}
	
	public Token2(int round, int agent) {
		this(null);
		this.agent = agent;
		this.round = round;
	}
	
	public int getAgent() {
		return agent;
	}
	
	public void setAgent(int agent) {
		this.agent = agent;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
	
}