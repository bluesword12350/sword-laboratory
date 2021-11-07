package top.bluesword.laboratory.harmony.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import top.bluesword.laboratory.harmony.ResourceTable;
import top.bluesword.laboratory.harmony.data.SampleItem;

import java.util.ArrayList;
import java.util.List;

public class ListAbilitySlice extends AbilitySlice {

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_page_listcontainer);
        initListContainer();
    }
    private void initListContainer() {
        ListContainer listContainer = (ListContainer) findComponentById(ResourceTable.Id_list_container);
        List<SampleItem> list = getData();
        SampleItemProvider sampleItemProvider = new SampleItemProvider(list, this);
        listContainer.setItemProvider(sampleItemProvider);
        list.add(new SampleItem("Item" + sampleItemProvider.getCount()));
        listContainer.setBindStateChangedListener(new Component.BindStateChangedListener() {
            @Override
            public void onComponentBoundToWindow(Component component) {
                // ListContainer初始化时数据统一在provider中创建，不直接调用这个接口；
                // 建议在onComponentBoundToWindow监听或者其他事件监听中调用。
                sampleItemProvider.notifyDataChanged();
            }

            @Override
            public void onComponentUnboundFromWindow(Component component) {}
        });
    }
    private ArrayList<SampleItem> getData() {
        ArrayList<SampleItem> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            list.add(new SampleItem("Item" + i));
        }
        return list;
    }
}
