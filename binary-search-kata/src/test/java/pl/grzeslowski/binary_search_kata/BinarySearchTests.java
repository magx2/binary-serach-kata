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

    private BinarySearchArray<Integer> bsa;
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
        final Integer object = 5;

        // expected
        final boolean expected = true;

        // when
        bsa.add(object);

        // then
        final boolean contains = bsa.contains(object);
        assertThat(contains).isEqualTo(expected);
    }

    @Test
    public void add_in_first() throws Exception {

        // given
        final Integer object = 5;
        final Integer object2 = 1;

        // expected
        final boolean expected = true;
        final boolean expected2 = true;

        // when
        bsa.add(object);
        bsa.add(object2);

        // then
        final boolean contains = bsa.contains(object);
        assertThat(contains).isEqualTo(expected);
        final boolean contains2 = bsa.contains(object2);
        assertThat(contains2).isEqualTo(expected2);
    }

    @Test
    public void add_in_last() throws Exception {

        // given
        final Integer object = 5;
        final Integer object2 = 10;

        // expected
        final boolean expected = true;
        final boolean expected2 = true;

        // when
        bsa.add(object);
        bsa.add(object2);

        // then
        final boolean contains = bsa.contains(object);
        assertThat(contains).isEqualTo(expected);
        final boolean contains2 = bsa.contains(object2);
        assertThat(contains2).isEqualTo(expected2);
    }

    @Test
    public void add_in_middle() throws Exception {

        // given
        final Integer object = 5;
        final Integer object2 = 1;
        final Integer object3 = 14;

        // expected
        final boolean expected = true;
        final boolean expected2 = true;
        final boolean expected3 = true;

        // when
        bsa.add(object);
        bsa.add(object2);
        bsa.add(object3);

        // then
        final boolean contains = bsa.contains(object);
        assertThat(contains).isEqualTo(expected);
        final boolean contains2 = bsa.contains(object2);
        assertThat(contains2).isEqualTo(expected2);
        final boolean contains3 = bsa.contains(object3);
        assertThat(contains3).isEqualTo(expected3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_twice() throws Exception {

        // given
        final Integer object = 5;

        // when
        bsa.add(object);
        bsa.add(object);
    }

    @Test
    public void contains_but_this_object_is_not_in_array() throws Exception {

        // given
        final Integer object = 5;
        final Integer objectNotInArray = 10;
        bsa.add(object);

        // expected
        final boolean expected = false;

        // when
        final boolean contains = bsa.contains(objectNotInArray);

        // then
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
        final Integer object = 100;
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
        final Integer object = 123;

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

        // given
        final Integer object = 992;

        // when
        bsa.findIndex(object);
    }

    @Test(expected = IllegalArgumentException.class)
    public void find_one_element_not_in() throws Exception {

        // given
        final Integer otherObject = 1233;
        final Integer object = 11222;
        bsa.add(object);

        // when
        bsa.findIndex(otherObject);
    }

    @Test
    public void find_one_element_in_bsa() throws Exception {

        // given
        final Integer object = 11;
        bsa.add(object);

        // expected
        final int expected = 0;

        // when
        final int findIndex = bsa.findIndex(object);

        // then
        assertThat(findIndex).isEqualTo(expected);
    }

    @Test
    public void find_three_elements_in_bsa_idx_0() throws Exception {

        // given
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 444;
        bsa.add(object1);
        bsa.add(object2);
        bsa.add(object);

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
        final Integer object = 22;
        final Integer object1 = 333;
        final Integer object2 = 444;
        bsa.add(object2);
        bsa.add(object);
        bsa.add(object1);

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
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 997;
        bsa.add(object);
        bsa.add(object2);
        bsa.add(object1);

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
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 997;
        final Integer notIn = 1;
        bsa.add(object2);
        bsa.add(object1);
        bsa.add(object);

        // when
        bsa.findIndex(notIn);
    }

    @Test
    public void find_four_elements_in_bsa_idx_0() throws Exception {

        // given
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 997;
        final Integer object3 = 10000;
        bsa.add(object1);
        bsa.add(object);
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
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 997;
        final Integer object3 = 10000;
        bsa.add(object3);
        bsa.add(object2);
        bsa.add(object1);
        bsa.add(object);

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
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 997;
        final Integer object3 = 10000;
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object3);
        bsa.add(object2);

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
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 997;
        final Integer object3 = 10000;
        bsa.add(object2);
        bsa.add(object1);
        bsa.add(object);
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
        final Integer object = 222;
        final Integer object1 = 333;
        final Integer object2 = 997;
        final Integer object3 = 10000;
        final Integer notIn = -10000;
        bsa.add(object);
        bsa.add(object1);
        bsa.add(object2);
        bsa.add(object3);

        // when
        bsa.findIndex(notIn);
    }
}
