package MultiplayerPausePlugin;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.net.Administration.*;
import mindustry.world.blocks.storage.*;
import static mindustry.Vars.*;
import mindustry.net.Net.*;
import mindustry.net.*;
import mindustry.net.Packets.*;
import mindustry.core.GameState.*;


public class MultiplayerPausePlugin extends Plugin{
    @Override
    public void init(){
        Events.on(PlayerJoin.class, e -> {
             if (Groups.player.size() > 0 && state.serverPaused == true) {
                Log.info("Someone joined and serverstate was paused - Unpausing server - Plugin");
                state.serverPaused = false;
            }
        });

        Events.on(PlayerLeave.class, e -> {
            if (Groups.player.size()-1 == 0) {
                Log.info("Last player left server - Pausing server - Plugin");
                state.serverPaused = true;
            }
        });
    }
}
