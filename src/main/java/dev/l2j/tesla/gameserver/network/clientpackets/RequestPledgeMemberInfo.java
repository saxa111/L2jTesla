package dev.l2j.tesla.gameserver.network.clientpackets;

import dev.l2j.tesla.gameserver.network.serverpackets.PledgeReceiveMemberInfo;
import dev.l2j.tesla.gameserver.model.actor.Player;
import dev.l2j.tesla.gameserver.model.pledge.Clan;
import dev.l2j.tesla.gameserver.model.pledge.ClanMember;

/**
 * Format: (ch) dS
 * @author -Wooden-
 */
public final class RequestPledgeMemberInfo extends L2GameClientPacket
{
	@SuppressWarnings("unused")
	private int _pledgeType;
	private String _player;
	
	@Override
	protected void readImpl()
	{
		_pledgeType = readD();
		_player = readS();
	}
	
	@Override
	protected void runImpl()
	{
		final Player activeChar = getClient().getPlayer();
		if (activeChar == null)
			return;
		
		// do we need powers to do that??
		final Clan clan = activeChar.getClan();
		if (clan == null)
			return;
		
		final ClanMember member = clan.getClanMember(_player);
		if (member == null)
			return;
		
		activeChar.sendPacket(new PledgeReceiveMemberInfo(member));
	}
}