package factory;

import entity.PersonalArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class ArrayAbstractFactory {
    private static final Logger logger = LoggerFactory.getLogger(ArrayAbstractFactory.class);

    protected abstract PersonalArray createArray(int length);
    public PersonalArray orderArray(int length) {
        logger.debug("метод orderArray с параметром length={}", length);
        PersonalArray array = createArray(length);
        return array;
    }

}
