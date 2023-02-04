import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KeepYourCodeLeft {

    public void KeepYourCodeLeftExampleOne() {

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

    public void KeepYourCodeLeftExampleTwo() {

        Long[] ids = new Long[]{1L,5L,25L};
        List<Group> groups = new ArrayList<>();

        for (Long id: ids) {

            Optional<Product> optionalProduct = productRepository.findById(id);

            if (!optionalProduct.isPresent())
                continue;

            Product product = optionalProduct.get();

            Long[] groupIds = product.getGroupIds();

            if (groupIds == null)
                continue;

            for (Long groupId: groupIds) {
                Optional<Group> optionalGroup = groupRepository.findById(groupId);

                if (!optionalGroup.isPresent())
                    continue;

                groups.add(optionalGroup.get());
            }
        }
    }
}
