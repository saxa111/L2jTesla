package dev.l2j.tesla.gameserver.model.actor.instance;

import dev.l2j.tesla.gameserver.model.actor.template.NpcTemplate;
import dev.l2j.tesla.gameserver.enums.actors.ClassId;
import dev.l2j.tesla.gameserver.enums.actors.ClassRace;

public final class VillageMasterDElf extends VillageMaster
{
	public VillageMasterDElf(int objectId, NpcTemplate template)
	{
		super(objectId, template);
	}
	
	@Override
	protected final boolean checkVillageMasterRace(ClassId pclass)
	{
		if (pclass == null)
			return false;
		
		return pclass.getRace() == ClassRace.DARK_ELF;
	}
}