package top.bluesword.laboratory.harmony;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import top.bluesword.laboratory.harmony.slice.MainAbilitySlice;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }
}
