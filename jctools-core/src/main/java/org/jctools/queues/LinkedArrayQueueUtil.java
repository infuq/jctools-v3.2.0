package org.jctools.queues;

import org.jctools.util.InternalAPI;

import static org.jctools.util.UnsafeRefArrayAccess.REF_ARRAY_BASE;
import static org.jctools.util.UnsafeRefArrayAccess.REF_ELEMENT_SHIFT;

/**
 * This is used for method substitution in the LinkedArray classes code generation.
 */
@InternalAPI
final class LinkedArrayQueueUtil
{
    static int length(Object[] buf)
    {
        return buf.length;
    }

    /**
     * This method assumes index is actually (index << 1) because lower bit is used for resize.
     * This is compensated for by reducing the element shift(这可以通过减少元素移位来弥补).
     * The computation is constant folded, so there's no cost(计算是常数的，所以没有成本).
     */
    static long modifiedCalcCircularRefElementOffset(long index, long mask)
    {
        return REF_ARRAY_BASE + ((index & mask) << (REF_ELEMENT_SHIFT - 1));
    }

    static long nextArrayOffset(Object[] curr)
    {
        return REF_ARRAY_BASE + ((long) (length(curr) - 1) << REF_ELEMENT_SHIFT);
    }
}
