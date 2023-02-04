import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KeepYourCodeLeftOne {

    public void KeepYourCodeLeftExample() {

        Long[] ids = new Long[]{1L,5L,25L};
        List<Group> groups = new ArrayList<>();

        for (Long id: ids) {

            Optional<Product> optionalProduct = productRepository.findById(id);

            if(optionalProduct.isPresent()){
                Product product = optionalProduct.get();

                Long[] groupIds = product.getGroupIds();

                if (groupIds != null){

                    for (Long groupId: groupIds) {
                        Optional<Group> optionalGroup = groupRepository.findById(groupId);

                        if (optionalGroup.isPresent()){
                            groups.add(optionalGroup.get());
                        }
                    }
                }
            }

        }
    }


}
