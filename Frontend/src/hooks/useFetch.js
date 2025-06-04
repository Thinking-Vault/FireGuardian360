import { useState, useEffect } from 'react';
export function useFetch(fetchFn, args) {
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(true);
    useEffect(() => { fetchFn(...args).then(res=>{setData(res);setLoading(false);}); }, [fetchFn,...args]);
    return { data, loading };
}