package icantafford.newmorph;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CustomItem extends Item {
    public CustomItem(Settings settings){
        super(settings);
    }
    
    //version 1.21.2+
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand){
        user.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
        return ActionResult.SUCCESS;
    }
}