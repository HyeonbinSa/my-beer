package only.mybeer.domain.repository;

import only.mybeer.domain.Beer;
import only.mybeer.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 회원 정보 임시 저장
 */

@Repository
public class BeerRepository {
    private static final Map<Long, Beer> beerMap = new HashMap<>();
    private static long sequence = 0L;

    // 1. 맥주 등록
    public Beer save(Beer beer) {
        beer.setBeerId(++sequence);
        beerMap.put(beer.getBeerId(), beer);
        return beer;
    }

    // 2. 맥주 목록 조회
    public List<Beer> findAll() {
        return new ArrayList<>(beerMap.values());
    }

    // 3. 맥주 조회
    public Beer findById(Long id) {
        return beerMap.get(id);
    }

    // 4. 맥주 정보 수정
    public void update(Beer beer) {
        Beer updateBeer = beerMap.get(beer.getBeerId());
        updateBeer.setBeerName(beer.getBeerName());
        updateBeer.setBeerPrice(beer.getBeerPrice());
        updateBeer.setBeerName(beer.getBeerName());
        updateBeer.setAlc(beer.getAlc());
    }

    // 5. 맥주 삭제
    public void delete(Long id) {
        beerMap.remove(id);
    }
}
