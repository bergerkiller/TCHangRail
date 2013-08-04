package com.bergerkiller.bukkit.hangrail;

import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

import com.bergerkiller.bukkit.common.bases.IntVector3;
import com.bergerkiller.bukkit.common.entity.type.CommonMinecart;
import com.bergerkiller.bukkit.common.utils.FaceUtil;
import com.bergerkiller.bukkit.tc.rails.logic.RailLogicHorizontal;

public class RailLogicHanging extends RailLogicHorizontal {
	private static final RailLogicHanging[] values = new RailLogicHanging[8];
	static {
		for (int i = 0; i < 8; i++) {
			values[i] = new RailLogicHanging(FaceUtil.notchToFace(i));
		}
	}

	protected RailLogicHanging(BlockFace direction) {
		super(direction);
	}

	@Override
	public Vector getFixedPosition(CommonMinecart<?> entity, double x, double y, double z, IntVector3 railPos) {
		Vector pos = super.getFixedPosition(entity, x, y, z, railPos);
		pos.setY(pos.getY() - 2.0);
		return pos;
	}

	/**
	 * Gets the hanging rail logic to go into the direction specified
	 * 
	 * @param direction to go to
	 * @return Horizontal rail logic for that direction
	 */
	public static RailLogicHanging get(BlockFace direction) {
		return values[FaceUtil.faceToNotch(direction)];
	}
}
