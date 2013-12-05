package pl.grzeslowski.binary_search_kata;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class BinarySearchTests {

    private BinarySearchArray<Object> bsa;
    private final BinarySearchArrayFactory factory = new BinarySearchArrayFactory();
    private final Class<?> clazz;

    public BinarySearchTests(final Class<?> clazz) {
        this.clazz = clazz;
    }

    @Parameters
    public static Collection<Object[]> data() {
        final Object[][] data = new Object[][] {
                { RecursiveBinarySearch.class },
                { IterativeBinarySearch.class },
                { FunctionalBinarySearch.class } };
        return Arrays.asList(data);
    }

    @Before
    public void before() {
        bsa = factory.newBinarySearchArray(clazz);
    }

    @Test
    public void add_normal_test_case() throws Exception {

        // given
        final Object object = new Object();

        // expected
        final boolean expected = true;

        // when
        bsa.add(object);

        // then
        final boolean contains = bsa.contains(object);
        assertThat(contains).isEqualTo(expected);
    }

    @Test
    public void add_but_this_object_is_not_in_array() throws Exception {

        // given
        final Object object = new Object();
        final Object objectNotInArray = new Object();

        // expected
        final boolean expected = false;

        // when
        bsa.add(object);

        // then
        final boolean contains = bsa.contains(objectNotInArray);
        assertThat(contains).isEqualTo(expected);
    }

    @Test(expected = NullPointerException.class)
    public void add_null() throws Exception {

        // when
        bsa.add(null);
    }

    @Test(expected = NullPointerException.class)
    public void contains_null() throws Exception {

        // when
        bsa.contains(null);
    }

    @Test
    public void remove_was_in_bsa() throws Exception {

        // given
        final Object object = new Object();
        bsa.add(object);

        // expected
        final boolean expectedRemove = true;
        final boolean expectedContains = false;

        // when
        final boolean remove = bsa.remove(object);

        // then
        final boolean contains = bsa.contains(object);
        assertThat(remove).isEqualTo(expectedRemove);
        assertThat(contains).isEqualTo(expectedContains);
    }

    @Test
    public void remove_was_not_in_bsa() throws Exception {

        // given
        final Object object = new Object();

        // expected
        final boolean expectedRemove = false;
        final boolean expectedContains = false;

        // when
        final boolean remove = bsa.remove(object);

        // then
        final boolean contains = bsa.contains(object);
        assertThat(remove).isEqualTo(expectedRemove);
        assertThat(contains).isEqualTo(expectedContains);
    }

    @Test(expected = NullPointerException.class)
    public void remove_null() throws Exception {

        // when
        bsa.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void find_empty() throws Exception {

        // when
        bsa.findIndex(new Object());
    }

    @Test(expected = IllegalArgumentException.class)
    public void find_one_element_not_in() throws Exception {

        // given
        final Object otherObject = new Object();
        final Object object = new Object();
        bsa.add(object);

        // when
        bsa.findIndex(otherObject);
    }

    @Test
    public void find_one_element_in_bsa() throws Exception {

        // given
        final Object object = new Object();
        bsa.add(object);

        // expected
        final int expected = 1;

        // when
        final int findIndex = bsa.findIndex(object);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test
    public void find_three_elements_in_bsa_idx_0() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);

        // expected
        final int expected = 0;

        // when
        final int findIndex = bsa.findIndex(object);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test
    public void find_three_elements_in_bsa_idx_1() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);

        // expected
        final int expected = 1;

        // when
        final int findIndex = bsa.findIndex(object1);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test
    public void find_three_elements_in_bsa_idx_2() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);

        // expected
        final int expected = 2;

        // when
        final int findIndex = bsa.findIndex(object2);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void find_three_elements_not_in_bsa() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        final Object notIn = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);

        // when
        bsa.findIndex(notIn);
    }

    @Test
    public void find_four_elements_in_bsa_idx_0() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        final Object object3 = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);
        bsa.add(object3);

        // expected
        final int expected = 0;

        // when
        final int findIndex = bsa.findIndex(object);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test
    public void find_four_elements_in_bsa_idx_1() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        final Object object3 = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);
        bsa.add(object3);

        // expected
        final int expected = 1;

        // when
        final int findIndex = bsa.findIndex(object1);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test
    public void find_four_elements_in_bsa_idx_2() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        final Object object3 = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);
        bsa.add(object3);

        // expected
        final int expected = 2;

        // when
        final int findIndex = bsa.findIndex(object2);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test
    public void find_four_elements_in_bsa_idx_3() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        final Object object3 = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);
        bsa.add(object3);

        // expected
        final int expected = 3;

        // when
        final int findIndex = bsa.findIndex(object3);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void find_four_elements_not_in_bsa() throws Exception {

        // given
        final Object object = new Object();
        final Object object1 = new Object();
        final Object object2 = new Object();
        final Object object3 = new Object();
        final Object notIn = new Object();
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);
        bsa.add(object3);

        // when
        bsa.findIndex(notIn);
    }
}
