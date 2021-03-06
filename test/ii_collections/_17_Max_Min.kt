package ii_collections

import ii_collections.data.*
import org.junit.Assert.assertEquals
import org.junit.Test

class _17_Max_Min {
    @Test fun testCustomerWithMaximumNumberOfOrders() {
        assertEquals(customers[reka], shop.getCustomerWithMaximumNumberOfOrders())
    }

    @Test fun testTheMostExpensiveOrderedProduct() {
        assertEquals(rubyMine, customers[nathan]!!.getMostExpensiveOrderedProduct())
    }

    @Test fun testTheMostExpensiveProduct() {
        assertEquals(rubyMine, customers[nathan]!!.orders.first().getMostExpensiveProduct())
    }
}
