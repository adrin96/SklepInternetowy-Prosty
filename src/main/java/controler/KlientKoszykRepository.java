
package controler;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlientKoszykRepository extends JpaRepository<KlientKoszyk, Long>{
    
      List<KlientKoszyk> findByid(Long id);
      KlientKoszyk findById(int id);
      
}
