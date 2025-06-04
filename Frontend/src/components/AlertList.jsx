import React, { useState, useEffect } from 'react';
import { fetchAlerts } from '../api/alerts';
import {useFetch} from "../hooks/useFetch.js";
export function AlertList({lat,lng}) {
    const { data:alerts, loading } = useFetch(fetchAlerts, [lat,lng]);
    if (loading) return <div>Loading alerts...</div>;
    return (
        <ul>
            {alerts.map(a => <li key={a.id}>{a.type} lvl {a.level} at ({a.lat},{a.lng})</li>)}
        </ul>
    );
}
