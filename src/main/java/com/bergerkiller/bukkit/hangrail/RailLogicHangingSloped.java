package com.bergerkiller.bukkit.hangrail;

import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

import com.bergerkiller.bukkit.common.bases.IntVector3;
import com.bergerkiller.bukkit.common.entity.type.CommonMinecart;
import com.bergerkiller.bukkit.common.utils.FaceUtil;
import com.bergerkiller.bukkit.tc.rails.logic.RailLogicSloped;

public class RailLogicHangingSloped extends RailLogicSloped {
	private static final RailLogicHangingSloped[] values = new RailLogicHangingSloped[4];
	static {
		for (int i = 0; i < 4; i++) {
			values[i] = new RailLogicHangingSloped(FaceUtil.notchToFace(i << 1));
		}
	}

	protected RailLogicHangingSloped(BlockFace direction) {
		super(direction);
	}

	@Override
	public Vector getFixedPosition(CommonMinecart<?> entity, double x, double y, double z, IntVector3 railPos) {
		Vector pos = super.getFixedPosition(entity, x, y, z, railPos);
		pos.setY(pos.getY() - 3.0);
		return pos;
	}

	/**
	 * Gets the sloped hanging rail logic to go into the direction specified
	 * 
	 * @param direction to go to
	 * @return Sloped hanging rail logic for that direction
	 */
	public static RailLogicHangingSloped get(BlockFace direction) {
		return values[FaceUtil.faceToNotch(direction) >> 1];
	}
}
