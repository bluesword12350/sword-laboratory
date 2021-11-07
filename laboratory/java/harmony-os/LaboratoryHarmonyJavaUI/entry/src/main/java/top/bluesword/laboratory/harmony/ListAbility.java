package top.bluesword.laboratory.harmony;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import top.bluesword.laboratory.harmony.slice.ListAbilitySlice;

public class ListAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(ListAbilitySlice.class.getName());
    }
}
