export async function fetchAlerts(lat, lng, radius = 0.1) {
    const res = await fetch(`/alerts/nearby?lat=${lat}&lng=${lng}&radius=${radius}`);
    return await res.json();
}

export async function postAlert(alert) {
    const res = await fetch('/alerts', {
        method: 'POST', headers: { 'Content-Type':'application/json' },
        body: JSON.stringify(alert)
    });
    return await res.json();
}




